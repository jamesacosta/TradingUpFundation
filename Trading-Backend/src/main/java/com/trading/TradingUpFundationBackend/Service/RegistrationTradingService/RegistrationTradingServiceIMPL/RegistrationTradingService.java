package com.trading.TradingUpFundationBackend.Service.RegistrationTradingService.RegistrationTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.ClassTradingResponse.IClassTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.RegistrationTradingResponse.IRegistrationTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Converter.RegistrationTradingConverter.RegistrationTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.RegistrationTradingDTO.RegistrationTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.RegistrationTradingEntity.RegistrationTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.RegistrationTradingRepository.IRegistrationTradingRepository;
import com.trading.TradingUpFundationBackend.Service.RegistrationTradingService.IRegistrationTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Log4j2
public class RegistrationTradingService implements IRegistrationTradingService {
    @Autowired
    private IRegistrationTradingRepository repository;
    @Autowired
    private RegistrationTradingConverter converter;
    @Override
    public ResponseEntity<GenericResponseDTO> createRegistrationTrading(RegistrationTradingDTO registrationTradingDTO) {
        try{
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationTradingDTO.getId());
            if(!registrationTradingExist.isPresent()){
                RegistrationTradingEntity entity = this.converter.convertRegistrationTradingDTOToRegistrationTradingEntity(registrationTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readRegistrationTrading(RegistrationTradingDTO registrationTradingDTO) {
        try {
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationTradingDTO.getId());
            if(!registrationTradingExist.isPresent()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(registrationTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readRegistrationsTrading() {
        try {
            List<RegistrationTradingEntity> registrationTradingList = this.repository.findAll();
            if(!registrationTradingList.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(registrationTradingList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateRegistrationTrading(RegistrationTradingDTO registrationTradingDTO) {
        try {
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationTradingDTO.getId());
            if(registrationTradingExist.isPresent()){
                RegistrationTradingEntity entity = this.converter.convertRegistrationTradingDTOToRegistrationTradingEntity(registrationTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_UPDATED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteRegistrationTrading(Integer registrationId) {
        try {
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationId);
            if(registrationTradingExist.isPresent()){
                this.repository.deleteById(registrationId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
