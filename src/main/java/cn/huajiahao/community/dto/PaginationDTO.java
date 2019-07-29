package cn.huajiahao.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/7/26 9:54
 * @Created by 11744
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFistPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;


    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;

        for (int i = 0;i<3;i++){
            if (page - i > 0){
                pages.add(0,page-i);
            }
            if (page + i < totalPage){
                pages.add(page + i+1);
            }
        }

        //是否展示上一页
        if(page == 1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        //是否展示下一页
        if(page == totalPage){
            showNext = false;
        }else{
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)){
            showFistPage = false;
        }else{
            showFistPage = true;
        }

        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }
}
