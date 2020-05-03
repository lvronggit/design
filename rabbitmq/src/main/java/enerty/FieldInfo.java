package enerty;

/**
 * 代表一个冗余字段对象 
 * 需要使用 FieldInfoFactory 创建
 * @author cys
 *
 */
public class FieldInfo {

	/**
	 * 新增操作
	 */
	public static final int OP_ADD = 1;
	/**
	 * 修改操作
	 */
	public static final int OP_MOD = 2;
	/**
	 * 删除操作
	 */
	public static final int OP_DEL = 3;
	
	/**
	 * 字段标识 FieldSignConstant 常量
	 */
	private String fieldSign;
	/**
	 * 字段所在表的 id
	 */
	private String id;
	/**
	 * 字段的值
	 */
	private String value;
	/**
	 * 操作类型 1 新增, 2 修改, 3删除 FieldInfo 自带常量
	 */
	private int opreation;

	public static FieldInfo create(){
		return new FieldInfo();
	}
	
	public String getId() {
		return id;
	}

	public FieldInfo setId(String id) {
		this.id = id;
		return this;
	}

	public String getValue() {
		return value;
	}

	public FieldInfo setValue(String value) {
		this.value = value;
		return this;
	}

	public String getFieldSign() {
		return fieldSign;
	}

	public FieldInfo setFieldSign(String fieldSign) {
		this.fieldSign = fieldSign;
		return this;
	}
	
	public int getOpreation() {
		return opreation;
	}

	public FieldInfo setOpreation(int opreation) {
		this.opreation = opreation;
		return this;
	}

	@Override
	public String toString() {
		return "FieldInfo [fieldSign=" + fieldSign + ", id=" + id + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldSign == null) ? 0 : fieldSign.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldInfo other = (FieldInfo) obj;
		if (fieldSign == null) {
			if (other.fieldSign != null)
				return false;
		} else if (!fieldSign.equals(other.fieldSign))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
	
	
	
	
	
}
