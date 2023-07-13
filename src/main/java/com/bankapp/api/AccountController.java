package com.bankapp.api;

import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.exception.ErrorExtension;
import com.bankapp.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller for operations with account
 *
 * @author Shilov Maxim
 */

@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
@Tag(name = "Account controller", description = "API for work with accounts")
public class AccountController {

    private final AccountService accountService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create account", description = "Create account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Create account", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Invalid data", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public AccountResponse create(@Valid @RequestBody AccountRequest accountRequest) {
        return accountService.create(accountRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get account by account id", description = "Get account by account id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returned account", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Accounts with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public AccountResponse getById(@UUID @PathVariable String id) {
        return accountService.getById(id);
    }

    @GetMapping("/number/{number}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get account by account number", description = "Get account by account number")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returned account", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Accounts with this number not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public AccountResponse getByNumber(@UUID @PathVariable String number) {
        return accountService.getByNumber(number);
    }

    @GetMapping("/clientId/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all client's accounts", description = "Get list of all client's accounts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returned all client's accounts", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Accounts for user with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public List<AccountResponse> getAllUsersAccounts(@UUID @PathVariable String clientId) {
        return accountService.getAllClientAccounts(clientId);
    }

    @GetMapping("/active/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all client's accounts", description = "Get list of all client's accounts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returned all client's accounts", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Accounts for user with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public List<AccountResponse> getAllActiveUsersAccounts(@UUID @PathVariable String clientId) {
        return accountService.getAllActiveClientAccounts(clientId);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Make account inactive", description = "Make account inactive")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Terminated successfully"),
            @ApiResponse(responseCode = "404", description = "Account with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public void terminate(@UUID @PathVariable String id) {
        accountService.terminateAccount(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete account", description = "Delete account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public void delete(@UUID @PathVariable String id) {
        accountService.delete(id);
    }
}
