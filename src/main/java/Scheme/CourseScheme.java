package Scheme;

public class CourseScheme {

	private String name, imgUrl, token;
	private Integer price, realPrice;

	public String getName() {
		return name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(Integer realprice) {
		this.realPrice = realprice;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
