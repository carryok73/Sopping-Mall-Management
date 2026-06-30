package com.mall.management.controller;

import com.mall.management.service.CustomerService;
import com.mall.management.service.OwnerService;
import com.mall.management.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final CustomerService customerService;
    private final OwnerService ownerService;
    private final ShopService shopService;

    public DashboardController(CustomerService customerService, OwnerService ownerService, ShopService shopService) {
        this.customerService = customerService;
        this.ownerService = ownerService;
        this.shopService = shopService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("customerCount", customerService.count());
        model.addAttribute("ownerCount", ownerService.count());
        model.addAttribute("shopCount", shopService.count());
        model.addAttribute("shops", shopService.findAll());
        return "index";
    }
}
