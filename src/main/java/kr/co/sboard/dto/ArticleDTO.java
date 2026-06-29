package kr.co.sboard.dto;

import kr.co.sboard.entity.Article;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private int ano;
    private String type;
    private String title;
    private String content;
    private int comment;
    private int file;
    private int hit;
    private String writer;
    private String regip;
    private String wdate;

    public Article toEntity(){
        return Article.builder()
            .ano(ano)
            .type(type)
            .title(title)
            .content(content)
            .comment(comment)
            .file(file)
            .hit(hit)
            .writer(writer)
            .regip(regip)
            .build();
    }
}