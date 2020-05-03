package moive;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 影片类
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Moive {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;  // 名称
    private String _priceCode; // 价格（代号）

}
