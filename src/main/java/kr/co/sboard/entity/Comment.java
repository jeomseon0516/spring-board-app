package kr.co.sboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.co.sboard.dto.CommentDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private int parent;
    private String content;
    private String writer;
    private String regip;

    @CreationTimestamp
    private LocalDateTime wdate;

    public CommentDTO toDTO(){
        return CommentDTO.builder()
            .cno(cno)
            .parent(parent)
            .content(content)
            .writer(writer)
            .regip(regip)
            .wdate(wdate.toString())
            .build();
    }
}