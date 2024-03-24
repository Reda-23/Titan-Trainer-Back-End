package com.example.colossaltitan.controller;

import com.example.colossaltitan.dto.GroupTrainingDTO;
import com.example.colossaltitan.exception.ClientHasAlreadyBookedThisGroupTrainingException;
import com.example.colossaltitan.service.GroupTrainingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/groupT")
public class GroupTrainingRESTController {

    private GroupTrainingService groupTrainingService;


    @PostMapping("/")
    public ResponseEntity<GroupTrainingDTO> addGroupTraining(@RequestBody GroupTrainingDTO groupTrainingDTO){
        GroupTrainingDTO savedGT = groupTrainingService.addGroupTraining(groupTrainingDTO);
        return new ResponseEntity<>(savedGT, HttpStatus.OK);
    }

    @GetMapping("/groupTrainings")
    public ResponseEntity<List<GroupTrainingDTO>> groupTrainingList(){
        List<GroupTrainingDTO> groupTrainingDTOS = groupTrainingService.groupTrainingList();
        return new ResponseEntity<>(groupTrainingDTOS,HttpStatus.OK);
    }
    @PostMapping("/book/{clientId}/{groupTId}")
    public ResponseEntity<?> bookGroupTraining(@PathVariable Long clientId,@PathVariable Long groupTId) throws ClientHasAlreadyBookedThisGroupTrainingException {
        groupTrainingService.bookGroupTraining(clientId,groupTId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
