package com.sda.shop.controllers;

import com.sda.shop.models.CartItem;
import com.sda.shop.models.Item;
import com.sda.shop.models.Product;
import com.sda.shop.services.ItemServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/knight")
public class ItemsController {
    MainController mainController = new MainController();
    private ItemServise itemServise;
    private int mygold = mainController.mygold;

    public ItemsController(ItemServise itemServise) {
        this.itemServise = itemServise;
    }

    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("goldInPoach", mygold);
        model.addAttribute("itemsList", itemsList());
        return "items";
    }

    @GetMapping("/items/item/{id}")
    public String getItemDetailsByID(Model model, @PathVariable String id) {
        int iid = Integer.parseInt(id);
        for (Item item : itemsList()) {
            if (iid == item.getId()) {
                model.addAttribute("item", item);
                CartItem ci = new CartItem();
                ci.setProductName(item.getName());
                ci.setProductId(item.getId());
                model.addAttribute("CartItem", ci);
            }
        }
        model.addAttribute("goldInPoach", mygold);
        return "item";
    }

    public List<Item> itemsList() {
        return itemServise.getAllItems();
    }

    @GetMapping("/newitem")
    public String adminOpenAddProductForm(Model model) {
        model.addAttribute("item", new Item());
        return "newitem";
    }

    @PostMapping("/newitem")
    public String adminAddProduct(@ModelAttribute Item item, Model model) {
        model.addAttribute("item", item);
//        product.setId(Product.ID_GENERATOR++);
        itemServise.addItem(item);
        return "redirect:/knight/items";
    }

    @GetMapping("/removeitem")
    public String OpenremoveProductForm(Model model) {
        model.addAttribute("item", new Item());
        return "removeitem";
    }

    @PostMapping("/removeitem")
    public String removeProduct(@ModelAttribute Item item, Model model) {
        model.addAttribute("item", item);
        itemServise.removeItemByID(item);
        return "redirect:/knight/items";
    }
}
