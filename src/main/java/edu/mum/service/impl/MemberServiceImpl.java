package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional
public class MemberServiceImpl implements edu.mum.service.MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private UserCredentialsService credentialsService;

	public void save(Member member) {
		memberDao.save(member);
	}

	public void update(Member member) {
		memberDao.update(member);
	}

	@Override
	public void saveFull(Member member) {
		credentialsService.save(member.getUserCredentials());
		memberDao.save(member);
	}

	public List<Member> findAll() {
		return (List<Member>) memberDao.findAll();
	}

	public Member findByMemberNumber(Integer memberId) {
		return memberDao.findByMemberNumber(memberId);
	}

	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}

	public Member findOneFull(Long id) {
		Member member = this.findOne(id);

		// OR "SELECT p FROM Member m JOIN FETCH m.userCredentials WHERE m.id =
		// (:id)"
		member.getUserCredentials();

		return member;
	}

	public List<Member> findAllJoinFetch() {
		return memberDao.findAllJoinFetch();
	}

	@Override
	public List<Member> findByGraph() {
		return memberDao.findByGraph();
	}
}