

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserErrorResponse {
    private int status;
    private String message;
    private Date timestamp;
}
