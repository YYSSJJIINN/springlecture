package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private int seqeunce;
    private String id;
    private String pwd;
    private String name;

//    public MemberDTO() {
//    }
//
//    public MemberDTO(int seqeunce, String id, String pwd, String name) {
//        this.seqeunce = seqeunce;
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
//    }
//
//    public int getSeqeunce() {
//        return seqeunce;
//    }
//
//    public void setSeqeunce(int seqeunce) {
//        this.seqeunce = seqeunce;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "MemberDTO{" +
//                "seqeunce=" + seqeunce +
//                ", id='" + id + '\'' +
//                ", pwd='" + pwd + '\'' +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
