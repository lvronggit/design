package moive;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 顾客租赁
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Rental {

    private Moive _moive; //电影
    private int _daysRented; // 租期


}
