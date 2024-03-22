package com.sam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sam.app.board.SearchVO;
import com.sam.app.reply.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(Long bno, SearchVO svo);

	int insertReply(ReplyVO vo);
}
