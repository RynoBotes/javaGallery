package za.ac.nwu.ga.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;
import za.ac.nwu.ga.domain.service.GeneralResponse;
import za.ac.nwu.ga.logic.flow.CreateMemberFlow;
import za.ac.nwu.ga.logic.flow.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("member-info")

public class MemberInfoController
{
    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;

    @Autowired
    public MemberInfoController(FetchMemberFlow fetchMemberFlow, CreateMemberFlow createMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }

    @GetMapping("/all")
    //    @RuequestMapping(produces = "application/json")
    @ApiOperation(value = "Get all configured members",notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members retrieved",response = GeneralResponse.class),
            @ApiResponse(code = 400,message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<MemberInfoDto>>> all()
    {
        List<MemberInfoDto> members = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberInfoDto>> response = new GeneralResponse<>(true ,members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Create a new account
    @PostMapping("")
    @ApiOperation(value = "Creates a new member.", notes = "Creates a new member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "The member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400,message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberInfoDto>> create(
            @ApiParam(value = "Request body to create a new member",required = true)
            @RequestBody MemberInfoDto memberInfo)
    {
        MemberInfoDto memberInfoResponses = createMemberFlow.create(memberInfo);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true, memberInfoResponses);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{memberId}")
    @ApiOperation(value = "Fetch specified member ",notes = "Fetch specified member  corresponding to memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Member Returned"),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberInfoDto>> getMemberById(
            @ApiParam(value = "The id that uniquely identifies the member.",
                    example = "3",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId) {
        MemberInfoDto member = fetchMemberFlow.getMemberById(memberId);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("{memberId}")
    @ApiOperation(value = "update specified member ",notes = "update specified member by corresponding to memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Member Returned"),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberInfoDto>> updateMember(
            @ApiParam(value = "The ID that uniquely identifies the memberId.",
                    example = "2",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId,
            @ApiParam(value = "The name that uniquely identifies the member.",
                    example = "Ryno",
                    name = "newMemberFName",
                    required = true)
            @RequestParam("newMemberFName") final String newMemberFName,
            @ApiParam(value = "The surname that uniquely identifies the memberID.",
                    example = "Botes",
                    name = "newMemberLName",
                    required = true)
            @RequestParam("newMemberLName") final String newMemberLName,
            @ApiParam(value = "The email that uniquely identifies the memberID.",
                    example = "10110001",
                    name = "newMemberEmail",
                    required = true)
            @RequestParam("newMemberEmail") final String newMemberEmail
    )
    {

        MemberInfoDto member = createMemberFlow.updateMember(memberId, newMemberFName, newMemberLName,newMemberEmail);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{memberId}")
    @ApiOperation(value = "Delete specified member ",notes = "Delete specified member  corresponding to memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Member Deleted"),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberInfoDto>> deleteMember(
            @ApiParam(value = "The id that uniquely identifies the member.",
                    example = "3",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId) {
        MemberInfoDto member = fetchMemberFlow.deleteMember(memberId);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
