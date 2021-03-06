package com.qianli.groupon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author meng
 * @create 2017-07-30 23:47
 */

// 被维护端(有外键方)
@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    //mappedBy表示被维护端
    @OneToOne(mappedBy = "article",cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "detail_id")
    private ArticleDetail articleDetail;

    //    @JoinColumn(name = "article_id")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "article")
    private List<ArticleTag> articleTags;
}
