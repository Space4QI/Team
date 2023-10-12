package ru.zulvit.teamentropy.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zulvit.teamentropy.service.LicenseKeyGenerator;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/flow")
public class FlowAPIController {
    private final LicenseKeyGenerator licenseKeyGenerator;

    @Autowired
    public FlowAPIController(LicenseKeyGenerator licenseKeyGenerator) {
        this.licenseKeyGenerator = licenseKeyGenerator;
    }

    @PostMapping("/authorize")
    @Operation(
            summary = "Authorize a user",
            description = "Checks if a user's email and password are valid and returns an authorization status.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful authorization"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    )
            }
    )
    public ResponseEntity<?> authorize(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        // todo Тут проверка email и password с использованием кастомного шифрования
        return new ResponseEntity<>("Authorized", HttpStatus.OK);
    }

    @PostMapping("/account-info")
    @Operation(
            summary = "Get account information",
            description = "Retrieve the details of the user account from the database.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved account information"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Account not found"
                    )
            }
    )
    public ResponseEntity<?> getAccountInfo() {
        // todo: Предположим, что данные об аккаунте берутся из базы данных
        Map<String, Object> accountInfo = new HashMap<>();
        accountInfo.put("email", "user@example.com");
        accountInfo.put("license_keys", "some_license_keys");
        accountInfo.put("avatar_url", "http://avatar.example.com");
        return new ResponseEntity<>(accountInfo, HttpStatus.OK);
    }

    @PostMapping("/updates")
    @Operation(
            summary = "Check for product updates",
            description = "Check if there are any updates available for a given product.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully checked for updates"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found"
                    )
            }
    )
    public ResponseEntity<?> checkForUpdates(@RequestBody Map<String, String> request) {
        String productName = request.get("productName");
        // todo: Тут логика проверки обновлений
        boolean updatesAvailable = true;
        return new ResponseEntity<>(updatesAvailable, HttpStatus.OK);
    }

    @PostMapping("/check-license")
    @Operation(
            summary = "Check product license",
            description = "Generate and return a license key for a given product and flowStone string.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully generated license key"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid product or flowStone string"
                    )
            }
    )
    public ResponseEntity<?> checkLicense(@RequestBody Map<String, String> request) {
        String productName = request.get("productName");
        String flowStoneString = request.get("flowStoneString");
        String licenseKey = licenseKeyGenerator.generateLicenseKey(flowStoneString, productName);
        return new ResponseEntity<>(licenseKey, HttpStatus.OK);
    }
}
