/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.7
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.ClientRegistrationResponse;
import io.swagger.client.model.Error;
import io.swagger.client.model.ParticipantConfig;
import io.swagger.client.model.PeraProduct;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for BootstrapApi
 */
@Ignore
public class BootstrapApiTest {

    private final BootstrapApi api = new BootstrapApi();

    /**
     * [PHASE 2] Get an OFxPERA Participant&#x27;s registration information
     *
     * API for retrieving registration information for a specific OFxPERA Participant
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getParticipantTest() throws Exception {
        String participantId = null;
        String participantId = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        ParticipantConfig response = api.getParticipant(participantId, participantId, xV, xFapiInteractionId);

        // TODO: test validations
    }
    /**
     * [PHASE 1] Get a list of registered OFxPERA Participants
     *
     * API for retrieving all registered OFxPERA Participants
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void listParticipantsTest() throws Exception {
        String participantId = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        List<ParticipantConfig> response = api.listParticipants(participantId, xV, xFapiInteractionId);

        // TODO: test validations
    }
    /**
     * [PHASE 1] Get a list of PERA products associated with PERA Admin
     *
     * API for retrieving all registered products associated with the PERA Admin.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void listProductByParticipantTest() throws Exception {
        String participantId = null;
        String participantId = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        List<PeraProduct> response = api.listProductByParticipant(participantId, participantId, xV, xFapiInteractionId);

        // TODO: test validations
    }
    /**
     * [PHASE 2] Register an OFxPERA Participant
     *
     * API for registering an OFxPERA Participant following FAPI Dynamic Client Registration requirements
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void registerParticipantTest() throws Exception {
        ParticipantConfig body = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        ClientRegistrationResponse response = api.registerParticipant(body, xV, xFapiInteractionId);

        // TODO: test validations
    }
    /**
     * [PHASE 2] Register a PERA Admin Product
     *
     * API that allows PERA Admin to register a PERA product.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void registerProductTest() throws Exception {
        String participantId = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        PeraProduct response = api.registerProduct(participantId, xV, xFapiInteractionId);

        // TODO: test validations
    }
    /**
     * [PHASE 2] Update an OFxPERA Participant
     *
     * API for updating the URIs and status of an OFxPERA Participant
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void updateParticipantTest() throws Exception {
        ParticipantConfig body = null;
        String participantId = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        ClientRegistrationResponse response = api.updateParticipant(body, participantId, xV, xFapiInteractionId);

        // TODO: test validations
    }
    /**
     * [PHASE 2] Update a PERA Admin Product
     *
     * API that allows PERA Admin to update their product.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void updateProductTest() throws Exception {
        String productId = null;
        String participantId = null;
        Integer xV = null;
        UUID xFapiInteractionId = null;
        PeraProduct response = api.updateProduct(productId, participantId, xV, xFapiInteractionId);

        // TODO: test validations
    }
}
