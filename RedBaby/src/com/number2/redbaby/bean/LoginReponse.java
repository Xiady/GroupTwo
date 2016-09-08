package com.number2.redbaby.bean;

public class LoginReponse {
	private String response;
	private UserInfo userinfo;

	public LoginReponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginReponse(String response, UserInfo userinfo) {
		super();
		this.response = response;
		this.userinfo = userinfo;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	@Override
	public String toString() {
		return "LoginReponse [response=" + response + ", userinfo=" + userinfo
				+ "]";
	}

	public class UserInfo {
		private String userId;
		private String usersession;

		public UserInfo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserInfo(String userId, String usersession) {
			super();
			this.userId = userId;
			this.usersession = usersession;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUsersession() {
			return usersession;
		}

		public void setUsersession(String usersession) {
			this.usersession = usersession;
		}

		@Override
		public String toString() {
			return "UserInfo [userId=" + userId + ", usersession="
					+ usersession + "]";
		}

	}
}
