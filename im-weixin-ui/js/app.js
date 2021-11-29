window.app = {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @returns {boolean}
	 * true: 不为空
	 * false：为空
	 */
	isNotNull: function(str) {
		if (str != null && str != "" && str != undefined) {
			return true;
		}
		return false;
	},
	showToast: function(msg, type) {
		plus.nativeUI.toast(msg, {
			icon: "image/" + type + ".png",
			verticalAlign: "center"
		});
	}

}
