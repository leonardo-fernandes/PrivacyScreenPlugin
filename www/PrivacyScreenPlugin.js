var exec = require("cordova/exec");

var PLUGIN_NAME = "PrivacyScreen";

module.exports.enable = function (success, error) {
	exec(success, error, PLUGIN_NAME, "enable", []);
};

module.exports.disable = function (success, error) {
	exec(success, error, PLUGIN_NAME, "disable", []);
};