package cn.scorpiodong.blog.util;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/11 7:38 下午
 */
public class JsonResult {

    private String msg;
    private String code;
    private Object data;

    public static final JsonResult SUCCESS = of("200", "成功", null);
    public static final JsonResult DEFAULT_ERROR = of("400", "失败", null);
    public static final JsonResult TOKEN_ERROR = of("400", "Token验证失败", null);

    private JsonResult(String code, String msg, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static JsonResult of(Object data) {
        return of("200", "成功", data);
    }

    public static JsonResult of(String code, String msg, Object data) {
        return new JsonResult(code, msg, data);
    }

    public JsonResult code(String code) {
        this.code = code;
        return this;
    }

    public JsonResult msg(String msg) {
        this.msg = msg;
        return this;
    }

    public JsonResult data(Object data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
