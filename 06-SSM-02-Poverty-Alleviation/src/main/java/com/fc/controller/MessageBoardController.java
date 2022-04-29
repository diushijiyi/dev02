package com.fc.controller;


import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("msgboard")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;
    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            Long id){
        return messageBoardService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVO add(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id){
        return messageBoardService.delete(id);
    }

}
