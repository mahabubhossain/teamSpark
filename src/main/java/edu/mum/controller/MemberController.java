package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Member;
import edu.mum.service.MemberService;

@RestController
@RequestMapping({ "/members" })
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping
	public @ResponseBody List<Member> findAll() {
		return memberService.findAll();

	}

	@RequestMapping("/{id}")
	public Member getMemberById(@PathVariable("id") Long id) {
		return memberService.findOne(id);

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Member processAddNewMemberForm(@RequestBody Member memberToBeAdded) {
		memberService.save(memberToBeAdded);
		return null;

	}

}
