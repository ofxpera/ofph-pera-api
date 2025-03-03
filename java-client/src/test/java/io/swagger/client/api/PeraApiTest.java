/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.5
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.Error;
import io.swagger.client.model.PeraArrangement;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for PeraApi
 */
@Ignore
public class PeraApiTest {

    private final PeraApi api = new PeraApi();

    /**
     * Get the status of a PERA arrangement
     *
     * API that allows FIs to retrieve the status of one or more PERA Arrangements
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getArrangementStatusTest() throws Exception {
        String arrangementId = null;
        PeraArrangement response = api.getArrangementStatus(arrangementId);

        // TODO: test validations
    }
    /**
     * Registers a new PERA arrangement
     *
     * API that allows PERA Admins to register the successful creation of one or more new PERA Arrangements
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void peraArrangementRegistrationTest() throws Exception {
        PeraArrangement response = api.peraArrangementRegistration();

        // TODO: test validations
    }
}
