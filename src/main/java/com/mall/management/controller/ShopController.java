package com.mall.management.controller;

import com.mall.management.entity.Shop;
import com.mall.management.service.OwnerService;
import com.mall.management.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final OwnerService ownerService;

    public ShopController(ShopService shopService, OwnerService ownerService) {
        this.shopService = shopService;
        this.ownerService = ownerService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("shops", shopService.findAll());
        return "shops/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("shop", new Shop());
        model.addAttribute("owners", ownerService.findAll());
        return "shops/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Shop shop, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("owners", ownerService.findAll());
            return "shops/form";
        }
        shopService.save(shop);
        return "redirect:/shops";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("shop", shopService.findById(id));
        model.addAttribute("owners", ownerService.findAll());
        return "shops/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shopService.deleteById(id);
        return "redirect:/shops";
    }
}
