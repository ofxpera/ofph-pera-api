package io.swagger.client.example;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.BootstrapApi;
import io.swagger.client.api.OAuthApi;
import io.swagger.client.model.OauthAuthBody;
import io.swagger.client.model.ParticipantConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;

/**
 * A simple example showing how to use the java-client to connect to the spring-mocks server.
 */
public class ClientExample {

    public static void main(String[] args) {
        System.out.println("Starting OFxPERA Java Client Example");
        
        // Configure the API client
        ApiClient apiClient = Configuration.getDefaultApiClient();
        apiClient.setBasePath("http://localhost:8080/voyager-innovation/OFxPERA/1.0.0");
        
        try {
            // Example 1: Get Participant (Bootstrap API)
            System.out.println("\n--- Example 1: Get Participant ---");
            BootstrapApi bootstrapApi = new BootstrapApi(apiClient);
            
            try {
                // Use getParticipant instead of getParticipants
                String participantId = "test-participant";
                String requestingParticipantId = "test-requester";
                Integer xV = 1; // API version
                UUID xFapiInteractionId = UUID.randomUUID();
                
                ParticipantConfig participant = bootstrapApi.getParticipant(
                    participantId, 
                    requestingParticipantId,
                    xV,
                    xFapiInteractionId
                );
                System.out.println("Participant: " + participant);
            } catch (ApiException e) {
                System.out.println("Error getting participant: " + e.getMessage());
                System.out.println("Status code: " + e.getCode());
            }
            
            // Example 2: OAuth PAR (Pushed Authorization Request)
            System.out.println("\n--- Example 2: OAuth PAR ---");
            OAuthApi oauthApi = new OAuthApi(apiClient);
            
            try {
                // Create OauthAuthBody with builder pattern
                List<OauthAuthBody.ScopeEnum> scopes = new ArrayList<>();
                scopes.add(OauthAuthBody.ScopeEnum.OPENID);
                scopes.add(OauthAuthBody.ScopeEnum.PROFILE);
                
                OauthAuthBody authBody = new OauthAuthBody()
                    .participantId("test-participant-id")
                    .responseType(OauthAuthBody.ResponseTypeEnum.CODE)
                    .scope(scopes)
                    .state(UUID.randomUUID().toString());
                
                String participantId = "test-participant-id";
                Integer xV = 1;
                OffsetDateTime xFapiAuthDate = OffsetDateTime.now();
                String xFapiCustomerIpAddress = "192.168.1.1";
                String xClientHeaders = "SGVhZGVycw=="; // Base64 encoded
                String xClientUserAgent = "VXNlckFnZW50"; // Base64 encoded
                UUID xIdempotencyKey = UUID.randomUUID();
                OffsetDateTime xFapiCustomerLastLoggedTime = OffsetDateTime.now();
                UUID xFapiInteractionId = null;
                
                // Note the correct order of parameters for oAuthPAR
                oauthApi.oAuthPAR(
                    authBody,
                    participantId, 
                    xV,
                    xFapiAuthDate,
                    xFapiCustomerIpAddress,
                    xClientHeaders,
                    xClientUserAgent,
                    xIdempotencyKey,
                    xFapiCustomerLastLoggedTime,
                    xFapiInteractionId
                );
                System.out.println("OAuth PAR request successful");
            } catch (ApiException e) {
                System.out.println("Error with OAuth PAR: " + e.getMessage());
                System.out.println("Status code: " + e.getCode());
            }
            
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nOFxPERA Java Client Example completed");
    }
}
