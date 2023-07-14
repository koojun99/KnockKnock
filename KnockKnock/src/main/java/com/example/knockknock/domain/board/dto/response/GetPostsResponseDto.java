package com.example.knockknock.domain.board.dto.response;
import com.example.knockknock.domain.board.entity.Post;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetPostsResponseDto {

    private Long postId;
    private String boardName;
    private String nickName;
    private String title;


    public static GetPostsResponseDto from(Post post) {
        String nickName;
        if (post.getIsAnonymous()) {
            nickName = "익명";
        } else {
            nickName = post.getMember().getNickName();
        }
        return GetPostsResponseDto.builder()
                .postId(post.getId())
                .boardName(post.getBoard().getBoardName())
                .nickName(nickName)
                .title(post.getTitle())
                .build();
    }


}
