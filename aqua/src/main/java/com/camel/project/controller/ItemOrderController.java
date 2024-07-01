package com.camel.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.camel.project.dto.ItemOrder;
import com.camel.project.service.ItemOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ItemOrderController {

	@Autowired
	private ItemOrderService itemOrderService;

	@GetMapping("/itemMain")
	public String getAllItem(Model model) {
		List<ItemOrder> item = itemOrderService.getAllItem();
		model.addAttribute("item", item);

		return "itemMain";
	}

	@GetMapping("/itemDetail/{itemNo}")
	public String getItemByNo(Model model, @PathVariable int itemNo) {
		ItemOrder itemOrder = itemOrderService.getItemByNo(itemNo);
		model.addAttribute("itemD", itemOrder);

		return "itemDetail";
	}

	@PostMapping("/orderInput")
	public String getOrderByNo(@RequestParam("orderQuantity") int orderQuantity, @RequestParam("totalPriceValue") int totalPrice, ItemOrder param, Model model) {
		ItemOrder setQuantity = new ItemOrder();
		setQuantity.setOrderQuantity(orderQuantity);

		ItemOrder setPrice = new ItemOrder();
		setPrice.setTotalPrice(totalPrice);

		param.setTotalPrice(totalPrice);

		ItemOrder loadName = itemOrderService.getOrderByNo(param);

		model.addAttribute("loadName", loadName);
		model.addAttribute("setQuantity", setQuantity);
		model.addAttribute("setTotalPrice", setPrice);
		model.addAttribute("order", param);

		return "orderInput";
	}

	@GetMapping("/orderInput")
	public String orderInputForm(Model model) {
		model.addAttribute("order", new ItemOrder());

		return "orderInput";
	}

	@PostMapping("/orderInfo")
	public String insertOrder(ItemOrder itemOrder, Model model) {
		itemOrderService.insertOrder(itemOrder);

		// 회원 ID로 주문 정보 조회
		List<ItemOrder> orderList = itemOrderService.getAllOrder(itemOrder.getMemberId());
		model.addAttribute("order", orderList);

		return "orderInfo";
	}

	@PostMapping("/cancelOrder")
	public String cancelOrder(@RequestParam("orderNos") Integer[] orderNos, Model model) {

		//orderNo에 해당하는 memberid를 먼저 찾자
		String memberId = null;
		List<ItemOrder> orderList = null;

		for (int orderNo : orderNos) {
			System.out.println("컨트롤러 시작합니다.");
			memberId = itemOrderService.getOrderMemberId(orderNo);
			itemOrderService.deleteOrder(orderNo);
		}

		System.out.println("memberId : " + memberId );

		orderList = itemOrderService.getAllOrder(memberId);

		System.out.println("orderList : " + orderList);

//		return "redirect:/orderInfo"; // 취소 후 orderInfo 페이지로 리다이렉트

		// orderList와 memberId를 모델에 추가
		model.addAttribute("order", orderList);
		//model.addAttribute("memberId", memberId);

		return "orderInfo";
	}

	// 수정해야 한다.
//	@GetMapping("/orderInfo")
//	public String getAllOrder(String memberId, Model model) {
	public String getAllOrder(ItemOrder dto , Model model) {
		System.out.println("get 일때.. : " + dto);
		List<ItemOrder> orderList = null;
//		List<ItemOrder> orderList = itemOrderService.getAllOrder(memberId);

		model.addAttribute("order", orderList);

		return "orderInfo";
	}

}
