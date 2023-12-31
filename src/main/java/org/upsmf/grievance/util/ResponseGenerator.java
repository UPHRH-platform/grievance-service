package org.upsmf.grievance.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class ResponseGenerator {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String failureResponse() throws JsonProcessingException {
		ObjectNode actualResponse = objectMapper.createObjectNode();
		ObjectNode response = objectMapper.createObjectNode();
		response.put(JsonKey.STATUS_CODE, ResponseCode.FAILURE.getErrorCode());
		response.put(JsonKey.STATUS_MESSAGE, ResponseCode.FAILURE.getErrorMessage());
		response.put(JsonKey.ERROR_MESSAGE, ResponseCode.FAILURE.getErrorMessage());
		actualResponse.putPOJO(JsonKey.STATUS, response);
		return JSONObjectUtil.getJsonString(objectMapper, actualResponse);
	}

	public static String failureResponse(String message) throws JsonProcessingException {
		ObjectNode actualResponse = objectMapper.createObjectNode();

		ObjectNode response = objectMapper.createObjectNode();
		response.put(JsonKey.STATUS_CODE, ResponseCode.FAILURE.getErrorCode());
		response.put(JsonKey.STATUS_MESSAGE, ResponseCode.FAILURE.getErrorMessage());
		response.put(JsonKey.ERROR_MESSAGE, message);
		actualResponse.putPOJO(JsonKey.STATUS, response);

		return JSONObjectUtil.getJsonString(objectMapper, actualResponse);
	}

	/**
	 * this method will crate success response and send to controller.
	 *
	 * @param obj
	 *            Object
	 * @return ObjectNode object.
	 */
	public static String successResponse(Object obj) throws JsonProcessingException {
		ObjectNode actualResponse = objectMapper.createObjectNode();

		ObjectNode response = objectMapper.createObjectNode();
		response.put(JsonKey.STATUS_CODE, ResponseCode.SUCCESS.getErrorCode());
		response.put(JsonKey.STATUS_MESSAGE, ResponseCode.SUCCESS.getErrorMessage());
		response.put(JsonKey.ERROR_MESSAGE, "");
		actualResponse.putPOJO(JsonKey.STATUS, response);
		if (obj != null) {
			actualResponse.putPOJO(JsonKey.RESPONSE_DATA, obj);
		}

		return JSONObjectUtil.getJsonString(objectMapper, actualResponse);
	}

	/**
	 * this method will crate success response and send to controller.
	 *
	 * @return ObjectNode object.
	 */
	public static String successResponse() throws JsonProcessingException {
		ObjectNode actualResponse = objectMapper.createObjectNode();

		ObjectNode response = objectMapper.createObjectNode();
		response.put(JsonKey.STATUS_CODE, ResponseCode.SUCCESS.getErrorCode());
		response.put(JsonKey.STATUS_MESSAGE, ResponseCode.SUCCESS.getErrorMessage());
		response.put(JsonKey.ERROR_MESSAGE, "");
		actualResponse.putPOJO(JsonKey.STATUS, response);

		return JSONObjectUtil.getJsonString(objectMapper, actualResponse);
	}
}
