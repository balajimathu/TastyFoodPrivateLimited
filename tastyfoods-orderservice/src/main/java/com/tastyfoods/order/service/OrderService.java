package com.tastyfoods.order.service;


import com.tastyfoods.order.dao.*;
import com.tastyfoods.order.dto.FoodOrderInfo;
import com.tastyfoods.order.dto.FoodOrderItem;
import com.tastyfoods.order.dto.OrderRequest;
import com.tastyfoods.order.dto.OrderResponse;
import com.tastyfoods.order.model.Customer;
import com.tastyfoods.order.model.Restaurant;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    FoodOrderItemRepository foodOrderItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        if(CollectionUtils.isEmpty(orderRequest.getFoodOrderItems())){
            return OrderResponse.builder()
                    .status("Please Choose Menu Items")
                    .build();
        }else{
            com.tastyfoods.order.model.FoodOrder foodOrder = new com.tastyfoods.order.model.FoodOrder();
            Optional<Customer> customer = customerRepository.findById(orderRequest.getCustomerId());
            foodOrder.setCustomer(customer.get());

            Optional<Restaurant> restaurant = restaurantRepository.findById(orderRequest.getRestaurantId());
            foodOrder.setRestaurant(restaurant.get());

            Double price = calculateTotalPrice(orderRequest.getFoodOrderItems());
            foodOrder.setPrice(price);

            foodOrder.setFoodOrderItems(mapFoodOrderItemDtoToModel(foodOrder,orderRequest.getFoodOrderItems()));
            com.tastyfoods.order.model.FoodOrder createdFoodOrder = orderRepository.save(foodOrder);

            FoodOrderInfo foodOrderInfo = FoodOrderInfo.builder().id(foodOrder.getId())
                    .customerId(orderRequest.getCustomerId())
                    .restaurantId(orderRequest.getRestaurantId())
                    .foodOrderItems(mapFoodOrderItemModelToDto(createdFoodOrder.getFoodOrderItems()))
                    .build();
            return OrderResponse.builder().
                    foodOrderInfo(foodOrderInfo)
                    .status("CREATED")
                    .totalPrice(foodOrder.getPrice())
                    .build();
        }
    }

    public OrderResponse updateOrder(long orderId, OrderRequest orderRequest) {

        Optional<com.tastyfoods.order.model.FoodOrder> foodOrder = orderRepository.findById(orderId);
        if(foodOrder.isPresent()) {
            foodOrder.get().getFoodOrderItems().forEach(foodOrderItem -> {
                foodOrderItemRepository.deleteById(foodOrderItem.getId());
            });

            Double price = calculateTotalPrice(orderRequest.getFoodOrderItems());
            foodOrder.get().setPrice(price);

            foodOrder.get().setFoodOrderItems(mapFoodOrderItemDtoToModel(foodOrder.get(),orderRequest.getFoodOrderItems()));

            com.tastyfoods.order.model.FoodOrder updatedFoodOrder = orderRepository.save(foodOrder.get());
            FoodOrderInfo foodOrderInfo = FoodOrderInfo.builder().id(orderId)
                    .customerId(foodOrder.get().getCustomer().getId())
                    .restaurantId(foodOrder.get().getRestaurant().getId())
                    .foodOrderItems(orderRequest.getFoodOrderItems())
                    .build();
            return OrderResponse.builder().
                    foodOrderInfo(foodOrderInfo)
                    .status(foodOrder.get().getStatus())
                    .totalPrice(foodOrder.get().getPrice())
                    .build();
        }else {
            return OrderResponse.builder()
                    .status("NO ORDER FOUND")
                    .build();
        }
    }

    public OrderResponse cancelOrder(long orderId) {

        Optional<com.tastyfoods.order.model.FoodOrder> foodOrder = orderRepository.findById(orderId);
        if (foodOrder.isPresent()) {
            orderRepository.deleteById(orderId);
            FoodOrderInfo foodOrderInfo = FoodOrderInfo.builder().id(orderId)
                    .build();
            return OrderResponse.builder().
                    foodOrderInfo(foodOrderInfo)
                    .status("CANCELLED")
                    .build();
        }else {
            return OrderResponse.builder()
                    .status("NO ORDER FOUND")
                    .build();
        }

    }

    public OrderResponse getOrder(long orderId) {
        Optional<com.tastyfoods.order.model.FoodOrder> foodOrder = orderRepository.findById(orderId);
        if(foodOrder.isPresent()) {

            Set<com.tastyfoods.order.dto.FoodOrderItem> menuItemsDtoList = foodOrder.get().getFoodOrderItems().stream()
                    .map(menuItem -> modelMapper.map(menuItem, com.tastyfoods.order.dto.FoodOrderItem.class))
                    .collect(Collectors.toSet());

            FoodOrderInfo foodOrderInfo = FoodOrderInfo.builder().id(orderId)
                    .customerId(foodOrder.get().getCustomer().getId())
                    .restaurantId(foodOrder.get().getRestaurant().getId())
                    .foodOrderItems(menuItemsDtoList)
                    .build();
            return OrderResponse.builder().
                    foodOrderInfo(foodOrderInfo)
                    .status(foodOrder.get().getStatus())
                    .totalPrice(foodOrder.get().getPrice())
                    .build();

        }else {
            return OrderResponse.builder()
                    .status("NO ORDER FOUND")
                    .build();
        }
    }

    public OrderResponse getPrice(OrderRequest orderRequest) {
        FoodOrderInfo foodOrderInfo = FoodOrderInfo.builder()
                .id(0)
                .customerId(orderRequest.getCustomerId())
                .restaurantId(orderRequest.getRestaurantId())
                .foodOrderItems(orderRequest.getFoodOrderItems())
                .build();
        return OrderResponse.builder()
                        .foodOrderInfo(foodOrderInfo)
                        .totalPrice(calculateTotalPrice(orderRequest.getFoodOrderItems()))
                        .status("PriceQuoted")
                        .build();
    }

    private Double calculateTotalPrice(Set<FoodOrderItem> menuItems) {
        Double totalPrice = menuItems.stream().map(menuItem ->
                menuItem.getQuantity() * menuItemRepository.findById(menuItem.getMenuItemId()).get().getPrice()).reduce(0.0,Double::sum);
        return totalPrice;
    }

    private Set<com.tastyfoods.order.model.FoodOrderItem> mapFoodOrderItemDtoToModel(com.tastyfoods.order.model.FoodOrder foodOrder, Set<FoodOrderItem> foodOrderItems) {
        Set<com.tastyfoods.order.model.FoodOrderItem> foodOrderItemSet = new HashSet<>();
        foodOrderItems.forEach(foodOrderItemDto -> {
            com.tastyfoods.order.model.FoodOrderItem foodOrderItemModel = new com.tastyfoods.order.model.FoodOrderItem();
            foodOrderItemModel.setQuantity(foodOrderItemDto.getQuantity());
            if(menuItemRepository.findById(foodOrderItemDto.getMenuItemId()).isPresent()) {
                foodOrderItemModel.setMenuItem(menuItemRepository.findById(foodOrderItemDto.getMenuItemId()).get());
            }
            foodOrderItemModel.setFoodOrder(foodOrder);
            foodOrderItemSet.add(foodOrderItemModel);
        });
        return foodOrderItemSet;
    }

    private Set<com.tastyfoods.order.dto.FoodOrderItem> mapFoodOrderItemModelToDto(Set<com.tastyfoods.order.model.FoodOrderItem> foodOrderItems) {
        Set<com.tastyfoods.order.dto.FoodOrderItem> foodOrderItemDtoList = foodOrderItems.stream()
                .map(menuItem -> modelMapper.map(menuItem, com.tastyfoods.order.dto.FoodOrderItem.class))
                .collect(Collectors.toSet());

        return foodOrderItemDtoList;
    }
}
