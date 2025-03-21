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

import io.swagger.client.model.ArrangementsBulkupdateBody;
import io.swagger.client.model.BulkConsentRequest;
import io.swagger.client.model.BulkConsentResponse;
import io.swagger.client.model.ConsentArrangementRequest;
import io.swagger.client.model.ConsentArrangementResponse;
import io.swagger.client.model.ConsentDashboard;
import io.swagger.client.model.ConsentExtensionRequest;
import io.swagger.client.model.ConsentHistory;
import io.swagger.client.model.ConsentStatusUpdate;
import io.swagger.client.model.ConsentTemplate;
import io.swagger.client.model.Error;
import io.swagger.client.model.InlineResponse2005;
import io.swagger.client.model.InlineResponse2006;
import org.threeten.bp.OffsetDateTime;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for ConsentApi
 */
@Ignore
public class ConsentApiTest {

    private final ConsentApi api = new ConsentApi();

    /**
     * Bulk update customer&#x27;s consent arrangements
     *
     * Update multiple consent arrangements for a specific customer in a single request. Based on: - Australia CDR Bulk Consumer Update - Korea MyData Consent Management 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void bulkUpdateCustomerConsentsTest() throws Exception {
        ArrangementsBulkupdateBody body = null;
        String customerId = null;
        InlineResponse2006 response = api.bulkUpdateCustomerConsents(body, customerId);

        // TODO: test validations
    }
    /**
     * Create bulk consent arrangements
     *
     * Create multiple consent arrangements in a single request. Based on: - Korea MyData Bulk Consent API - Singapore SGFinDex Multi-Institution Consent 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void createBulkConsentTest() throws Exception {
        BulkConsentRequest body = null;
        BulkConsentResponse response = api.createBulkConsent(body);

        // TODO: test validations
    }
    /**
     * Create a consent arrangement
     *
     * Create a new consent arrangement between a data holder and data recipient. Based on: - UK Open Banking Consent API v3.1.10 - Australia CDR Consent Management Standards v1.14.0 - Singapore SGFinDex Consent Framework 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void createConsentArrangementTest() throws Exception {
        ConsentArrangementRequest body = null;
        ConsentArrangementResponse response = api.createConsentArrangement(body);

        // TODO: test validations
    }
    /**
     * Extend consent arrangement duration
     *
     * Extend the duration of an existing consent arrangement. Based on: - Australia CDR Consent Amendment - UK Open Banking Re-authentication 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void extendConsentDurationTest() throws Exception {
        ConsentExtensionRequest body = null;
        String arrangementId = null;
        ConsentArrangementResponse response = api.extendConsentDuration(body, arrangementId);

        // TODO: test validations
    }
    /**
     * Get consent arrangement details
     *
     * Retrieve details of a specific consent arrangement. Based on: - UK Open Banking Account Access Consents API - Australia CDR Get Consent API 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getConsentArrangementTest() throws Exception {
        String arrangementId = null;
        ConsentArrangementResponse response = api.getConsentArrangement(arrangementId);

        // TODO: test validations
    }
    /**
     * Get consent arrangement history
     *
     * Retrieve the full history of changes to a consent arrangement. Based on: - Australia CDR Consent History API - UK Open Banking Consent Audit Requirements 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getConsentHistoryTest() throws Exception {
        String arrangementId = null;
        ConsentHistory response = api.getConsentHistory(arrangementId);

        // TODO: test validations
    }
    /**
     * Get customer&#x27;s consent dashboard
     *
     * Retrieve a comprehensive view of customer&#x27;s consent arrangements and data sharing. Based on: - Australia CDR Consumer Dashboard - UK Open Banking Consent Dashboard - Singapore SGFinDex Customer Portal 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCustomerConsentDashboardTest() throws Exception {
        String customerId = null;
        ConsentDashboard response = api.getCustomerConsentDashboard(customerId);

        // TODO: test validations
    }
    /**
     * Get customer&#x27;s consent arrangements
     *
     * Retrieve all consent arrangements for a specific customer. Based on: - UK Open Banking Customer Consent Management - Australia CDR Consumer Dashboard APIs - Singapore SGFinDex Customer Consent View 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCustomerConsentsTest() throws Exception {
        String customerId = null;
        String status = null;
        String dataHolderId = null;
        String purpose = null;
        InlineResponse2005 response = api.getCustomerConsents(customerId, status, dataHolderId, purpose);

        // TODO: test validations
    }
    /**
     * List consent arrangements
     *
     * Retrieve a list of active consent arrangements for the authenticated user. Based on: - UK Open Banking Account Access Consents API - Australia CDR Get Consent API 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void listConsentArrangementsTest() throws Exception {
        String status = null;
        OffsetDateTime fromDate = null;
        OffsetDateTime toDate = null;
        List<ConsentArrangementResponse> response = api.listConsentArrangements(status, fromDate, toDate);

        // TODO: test validations
    }
    /**
     * List available consent templates
     *
     * Retrieve available consent templates that can be used to create new arrangements. Based on: - Australia CDR Consent Taxonomy - UK Open Banking Standard Permissions 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void listConsentTemplatesTest() throws Exception {
        String category = null;
        String purpose = null;
        List<ConsentTemplate> response = api.listConsentTemplates(category, purpose);

        // TODO: test validations
    }
    /**
     * Revoke consent arrangement
     *
     * Revoke an existing consent arrangement. Based on: - UK Open Banking Account Access Consents API - Australia CDR Revoke Consent API - Korea MyData Consent Revocation API 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void revokeConsentArrangementTest() throws Exception {
        String arrangementId = null;
        api.revokeConsentArrangement(arrangementId);

        // TODO: test validations
    }
    /**
     * Update consent arrangement status
     *
     * Update the status of a consent arrangement (e.g., suspend, resume). Based on: - UK Open Banking Account Access Consents API - Australia CDR Update Consent API 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void updateConsentStatusTest() throws Exception {
        ConsentStatusUpdate body = null;
        String arrangementId = null;
        ConsentArrangementResponse response = api.updateConsentStatus(body, arrangementId);

        // TODO: test validations
    }
}
