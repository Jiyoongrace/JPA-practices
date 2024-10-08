package ex02.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "book", schema = "jpadb")
public class Book {
    @NotNull
    @Id
    @Column(nullable = false)
    private String id;

    @NotNull
    @Column(nullable = false, length = 200)
    private String title;
}