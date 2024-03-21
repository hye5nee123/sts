package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.SearchVO;
import com.example.demo.reply.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(Long bno, SearchVO svo);
	int insertReply(ReplyVO vo);
}
