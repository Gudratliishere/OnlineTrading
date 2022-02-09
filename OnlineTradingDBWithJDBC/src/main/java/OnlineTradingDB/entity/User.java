package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User
{
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String mail;
    @NonNull
    private String phone;
    @NonNull
    private String password;
    @NonNull
    private City city;
}
