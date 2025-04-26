package fun.maso.demo.valid1base.domain;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UserDTO {

    @NotBlank(message = "用户名不能为空") // 字符串：非null且去除头尾空格后不为空
    @Size(min = 2, max = 20, message = "用户名长度必须在 {min} 到 {max} 之间")
    private String username;

    @NotNull(message = "年龄不能为空") // 任何类型：不能为null
    @Min(value = 18, message = "年龄必须大于等于 {value}")
    @Max(value = 100, message = "年龄必须小于等于 {value}")
    private Integer age;

    @NotEmpty(message = "邮箱不能为空") // 字符串、集合、Map、数组：不能为null且长度/大小 > 0
    @Email(message = "邮箱格式不正确")
    private String email;

    @DecimalMin(value = "0.0", inclusive = true, message = "工资必须大于等于 {value}") // 数字：最小值（包含边界）
    @Digits(integer = 10, fraction = 2, message = "工资格式不正确，整数最多{integer}位，小数最多{fraction}位") // 数字：整数和小数位数
    private BigDecimal salary;

    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确") // 正则表达式校验
    private String phoneNumber;

    @AssertTrue(message = "必须同意用户协议") // Boolean：必须为 true
    private Boolean agreedToTerms;

    @FutureOrPresent(message = "生效日期必须是当前或未来日期") // 日期/时间：必须是现在或未来
    private java.time.LocalDate effectiveDate;

    @NotEmpty(message = "标签列表不能为空") // 集合：非null且size > 0
    @Size(min = 1, message = "至少需要一个标签")
    private List<String> tags;

}