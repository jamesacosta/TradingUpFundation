package com.trading.TradingUpFundationBackend.commons.domains.entity;

import jakarta.persistence.*;//Package to add the persistence to this entity
import lombok.Data;//Package of lombok to add the normal methods that an entity has

@Entity//Annotation to represent this class like an entity of a database for spring
@Data//Annotation to represent normal methods of a normal class
@Table(name = "book_trading")//Annotation to represent this entity like a table in a database represented with a name
/**
 * Class to represent the entity "book_trading" of the modeling "TradingUpFoundation"
 */
public class BookTradingEntity {
    @Id//Annotation to represent this attribute like an ID who represent this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Annotation who represent the way of how the id is going to work in each registration
    @Column(name = "book_id")//Annotation to represent this attribute like a column with a name in the table
    private Integer id;

    @Column(name = "book_name", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String name;

    @Column(name = "book_description", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String description;

    @Column(name = "book_image", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String image;

    @Column(name = "book_file", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String file;

    @Column(name = "book_level", nullable = false)//Annotation to represent this attribute like a column with a name in the table, it cant be null
    private Integer level;
}
