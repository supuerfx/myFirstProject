package com.example.mytestdemo.Controller;

import com.example.mytestdemo.Mapper.MemberMapper;
import com.example.mytestdemo.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberMapper memberMapper;

    @ResponseBody
    @RequestMapping("/listMember")
    public List<Member> getMemberList(){
        return memberMapper.findAll();
    }

    @RequestMapping("/addMember")
    public String addMember(String name){
        Member member=new Member();
        member.setName(name);
        memberMapper.saveMember(member);
        return "redirect:index.html";
    }

    @RequestMapping("/deleteMember")
    public String deleteMember(int id){
        memberMapper.deleteMemberById(id);
        return "redirect:index.html";
    }

    @RequestMapping("/updateMember")
    public String updataMember(String name,int id){
        Member member=new Member(id,name);
        memberMapper.update(member);
        return "redirect:index.html";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String getMemberById(int id){
        List<Member> list=memberMapper.findAll();
        for(Member member:list){
            if (id==member.getId()){
                return member.getName()+"<br><a href='index.html'>返回</a>";
            }
        }
        return "成员不存在"+"<br><a href='index.html'>返回</a>";
    }
}
