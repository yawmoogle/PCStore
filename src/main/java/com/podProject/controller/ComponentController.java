package com.podProject.controller;

import com.podProject.model.AdminProduct;
import com.podProject.service.AdminProductService;
import com.podProject.service.ComponentService;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/admin")
public class ComponentController {
    private static final Logger logger = LogManager.getLogger(ComponentController.class);

    @Autowired
    private AdminProductService adminProductService;

    @Autowired
    private ComponentService componentService;

    public ComponentController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }

    public void clearSession(HttpSession session) {
        session.removeAttribute("cpuName");
        session.removeAttribute("cpuPrice");
        session.removeAttribute("cpuCoolerName");
        session.removeAttribute("cpuCoolerPrice");
        session.removeAttribute("motherboardName");
        session.removeAttribute("motherboardPrice");
        session.removeAttribute("memoryName");
        session.removeAttribute("memoryPrice");
        session.removeAttribute("storageName");
        session.removeAttribute("storagePrice");
        session.removeAttribute("videoCardName");
        session.removeAttribute("videoCardPrice");
        session.removeAttribute("computerCaseName");
        session.removeAttribute("computerCasePrice");
        session.removeAttribute("powerSupplyName");
        session.removeAttribute("powerSupplyPrice");
    }

    @PostMapping("/saveAdminProduct")
    public String saveAdminProduct(HttpSession session, RedirectAttributes redirectAttributes) {
        String cpuName = (String) session.getAttribute("cpuName");
        String cpuPrice = (String) session.getAttribute("cpuPrice");
        String cpuCoolerName = (String) session.getAttribute("cpuCoolerName");
        String cpuCoolerPrice = (String) session.getAttribute("cpuCoolerPrice");
        String motherboardName = (String) session.getAttribute("motherboardName");
        String motherboardPrice = (String) session.getAttribute("motherboardPrice");
        String memoryName = (String) session.getAttribute("memoryName");
        String memoryPrice = (String) session.getAttribute("memoryPrice");
        String storageName = (String) session.getAttribute("storageName");
        String storagePrice = (String) session.getAttribute("storagePrice");
        String videoCardName = (String) session.getAttribute("videoCardName");
        String videoCardPrice = (String) session.getAttribute("videoCardPrice");
        String computerCaseName = (String) session.getAttribute("computerCaseName");
        String computerCasePrice = (String) session.getAttribute("computerCasePrice");
        String powerSupplyName = (String) session.getAttribute("powerSupplyName");
        String powerSupplyPrice = (String) session.getAttribute("powerSupplyPrice");

        double adminProductTotalPrice = computeAdminProductTotalPrice(cpuPrice, cpuCoolerPrice,
                                                                        motherboardPrice, memoryPrice,
                                                                        storagePrice, videoCardPrice,
                                                                        computerCasePrice, powerSupplyPrice
        );

        AdminProduct adminProduct = new AdminProduct(adminProductTotalPrice, cpuName, cpuPrice,
                                                    cpuCoolerName, cpuCoolerPrice,
                                                    motherboardName, motherboardPrice,
                                                    memoryName, memoryPrice,
                                                    storageName, storagePrice,
                                                    videoCardName, videoCardPrice,
                                                    computerCaseName, computerCasePrice,
                                                    powerSupplyName, powerSupplyPrice);

        this.adminProductService.saveAdminProduct(adminProduct);

        // Clear session to ensure data previously added does not interfere in next addition of adminProduct
        clearSession(session);

        return "redirect:/admin/products";
    }

    private double computeAdminProductTotalPrice(String... componentPrices) {
        double totalPrice = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        for (String price: componentPrices) {
            if (price != null) {
                totalPrice += Double.parseDouble(price);
            }
        }
        return Double.parseDouble(df.format(totalPrice));
    }

    @GetMapping("/adminProductComponents")
    public String showSelectedComponents(HttpSession session, Model model) {
        String cpuName = (String) session.getAttribute("cpuName");
        String cpuPrice = (String) session.getAttribute("cpuPrice");
        String cpuCoolerName = (String) session.getAttribute("cpuCoolerName");
        String cpuCoolerPrice = (String) session.getAttribute("cpuCoolerPrice");
        String motherboardName = (String) session.getAttribute("motherboardName");
        String motherboardPrice = (String) session.getAttribute("motherboardPrice");
        String memoryName = (String) session.getAttribute("memoryName");
        String memoryPrice = (String) session.getAttribute("memoryPrice");
        String storageName = (String) session.getAttribute("storageName");
        String storagePrice = (String) session.getAttribute("storagePrice");
        String videoCardName = (String) session.getAttribute("videoCardName");
        String videoCardPrice = (String) session.getAttribute("videoCardPrice");
        String computerCaseName = (String) session.getAttribute("computerCaseName");
        String computerCasePrice = (String) session.getAttribute("computerCasePrice");
        String powerSupplyName = (String) session.getAttribute("powerSupplyName");
        String powerSupplyPrice = (String) session.getAttribute("powerSupplyPrice");

        if (cpuName != null) {
            model.addAttribute("cpuName", cpuName);
            model.addAttribute("cpuPrice", cpuPrice);
        }

        if (cpuCoolerName != null) {
            model.addAttribute("cpuCoolerName", cpuCoolerName);
            model.addAttribute("cpuCoolerPrice", cpuCoolerPrice);
        }

        if (motherboardName != null) {
            model.addAttribute("motherboardName", motherboardName);
            model.addAttribute("motherboardPrice", motherboardPrice);
        }

        if (memoryName != null) {
            model.addAttribute("memoryName", memoryName);
            model.addAttribute("memoryPrice", memoryPrice);
        }

        if (storageName != null) {
            model.addAttribute("storageName", storageName);
            model.addAttribute("storagePrice", storagePrice);
        }

        if (videoCardName != null) {
            model.addAttribute("videoCardName", videoCardName);
            model.addAttribute("videoCardPrice", videoCardPrice);
        }

        if (computerCaseName != null) {
            model.addAttribute("computerCaseName", computerCaseName);
            model.addAttribute("computerCasePrice", computerCasePrice);
        }

        if (powerSupplyName != null) {
            model.addAttribute("powerSupplyName", powerSupplyName);
            model.addAttribute("powerSupplyPrice", powerSupplyPrice);
        }

        return "adminProductComponents"; // the view name where you want to display selected components
    }

    // CPU
    @GetMapping("/adminProductComponentsCpu")
    public String showCpu(HttpSession session, Model model) {
        String motherboardName = (String) session.getAttribute("motherboardName");
        if (motherboardName != null){
            String motherboardSocketCPU = componentService.getSocketTypeByMotherboardName(motherboardName);
            model.addAttribute("computerProcessor", componentService.getComputerProcessorsBySocketCPU(motherboardSocketCPU));
        } else {
            model.addAttribute("computerProcessor", componentService.displayAllCpu());
        }
        return "adminProductComponentsCpu";
    }

    @GetMapping("/addCpu")
    public String addCpu(@RequestParam("name") String cpuName, @RequestParam("price") String cpuPrice, HttpSession session) {
        session.setAttribute("cpuName", cpuName);
        session.setAttribute("cpuPrice", cpuPrice);
        return "redirect:/admin/adminProductComponents";
    }

    // CPU Cooler
    @GetMapping("/adminProductComponentsCpuCooler")
    public String showCpuCooler(Model model) {
        model.addAttribute("cpuCooler", componentService.displayAllCoolers()); // Note: "cpuCooler" attribute name
        return "adminProductComponentsCpuCooler";
    }

    @GetMapping("/addCpuCooler")
    public String addCpuCooler(@RequestParam("name") String cpuCoolerName, @RequestParam("price") String cpuCoolerPrice, HttpSession session) {
        session.setAttribute("cpuCoolerName", cpuCoolerName);
        session.setAttribute("cpuCoolerPrice", cpuCoolerPrice);
        return "redirect:/admin/adminProductComponents";
    }

    // Motherboard
    @GetMapping("/adminProductComponentsMotherboard")
    public String showMotherboard(HttpSession session, Model model) {
        String cpuName = (String) session.getAttribute("cpuName");
        if (cpuName != null) {
            // Retrieve the socket type of the selected CPU
            String cpuSocketType = componentService.getSocketTypeByCPUName(cpuName);
            // Filter motherboards by the CPU's socket type
            model.addAttribute("motherboard", componentService.getMotherboardsBySocketType(cpuSocketType));
        } else {
            // No CPU selected, display all motherboards
            model.addAttribute("motherboard", componentService.displayAllMotherboard());
        }
        return "adminProductComponentsMotherboard";
    }

    @GetMapping("/addMotherboard")
    public String addMotherboard(@RequestParam("name") String motherboardName, @RequestParam("price") String motherboardPrice, HttpSession session) {
        session.setAttribute("motherboardName", motherboardName);
        session.setAttribute("motherboardPrice", motherboardPrice);
        return "redirect:/admin/adminProductComponents";
    }

    // Memory
    @GetMapping("/adminProductComponentsMemory")
    public String showMemory(Model model) {
        model.addAttribute("memory", componentService.displayAllMemory());
        return "adminProductComponentsMemory";
    }

    @GetMapping("/addMemory")
    public String addMemory(@RequestParam("name") String memoryName, @RequestParam("price") String memoryPrice, HttpSession session) {
        session.setAttribute("memoryName", memoryName);
        session.setAttribute("memoryPrice", memoryPrice);
        return "redirect:/admin/adminProductComponents";
    }

    // Storage
    @GetMapping("/addStorage")
    public String addStorage(@RequestParam("name") String storageName, @RequestParam("price") String storagePrice, HttpSession session) {
        session.setAttribute("storageName", storageName);
        session.setAttribute("storagePrice", storagePrice);
        return "redirect:/admin/adminProductComponents";
    }

    @GetMapping("/adminProductComponentsStorage")
    public String showStorage(Model model) {
        model.addAttribute("storage", componentService.displayAllStorage());
        return "adminProductComponentsStorage";
    }

    // Video Card
    @GetMapping("/addVideoCard")
    public String addVideoCard(@RequestParam("name") String videoCardName, @RequestParam("price") String videoCardPrice, HttpSession session) {
        session.setAttribute("videoCardName", videoCardName);
        session.setAttribute("videoCardPrice", videoCardPrice);
        return "redirect:/admin/adminProductComponents";
    }

    @GetMapping("/adminProductComponentsVideoCard")
    public String showVideoCard(Model model) {
        model.addAttribute("videoCard", componentService.displayAllVideoCards());
        return "adminProductComponentsVideoCard";
    }

    // Case
    @GetMapping("/addComputerCase")
    public String addComputerCase(@RequestParam("name") String computerCaseName, @RequestParam("price") String computerCasePrice, HttpSession session) {
        session.setAttribute("computerCaseName", computerCaseName);
        session.setAttribute("computerCasePrice", computerCasePrice);
        return "redirect:/admin/adminProductComponents";
    }

    @GetMapping("/adminProductComponentsCase")
    public String showCase(Model model) {
        model.addAttribute("computerCase", componentService.displayAllCases());
        return "adminProductComponentsCase";
    }

    // Power Supply
    @GetMapping("/addPowerSupply")
    public String addPowerSupply(@RequestParam("name") String powerSupplyName, @RequestParam("price") String powerSupplyPrice, HttpSession session) {
        session.setAttribute("powerSupplyName", powerSupplyName);
        session.setAttribute("powerSupplyPrice", powerSupplyPrice);
        return "redirect:/admin/adminProductComponents";
    }

    @GetMapping("/adminProductComponentsPowerSupply")
    public String showPowerSupply(Model model) {
        model.addAttribute("powerSupply", componentService.displayAllPowerSupply());
        return "adminProductComponentsPowerSupply";
    }

    @GetMapping("/resetSelection")
    public String resetSelection(HttpSession session) {
        clearSession(session);
        return "redirect:/admin/adminProductComponents"; // Redirect back to the component selection page
    }

}
