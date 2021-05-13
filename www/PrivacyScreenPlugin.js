var exec = require("cordova/exec");

var PLUGIN_NAME = "PrivacyScreen";

exports.enable = function (success, error) {
	exec(success, error, PLUGIN_NAME, "enable", []);
};

exports.disable: function (success, error) {
	exec(success, error, PLUGIN_NAME, "disable", []);
};