package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IExerciseTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.controller.IExerciseTradingController;

import com.trading.TradingUpFundationBackend.service.Implements.ExerciseTradingServiceImplements;
import org.springframework.http.ResponseEntity;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
@RequestMapping(IExerciseTradingEndPoints.URL_EXERCISE)//Annotation which represent this controller with a specific url

/**
 * Controller of the entity ExerciseTrading
 * Implements the interface IExerciseTradingController
 */
public class ExerciseControllerImplements implements IExerciseTradingController {

    private final ExerciseTradingServiceImplements service;

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public ExerciseControllerImplements(ExerciseTradingServiceImplements service) {
        this.service = service;
    }

    /**
     * Method which creates an exercise using the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The exercise to be created
     * @return The method "createExerciseTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IExerciseTradingEndPoints.URL_EXERCISE_CREATE)
    public ResponseEntity<ObjectResponse> createExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO) {
        return this.service.createExerciseTrading(exerciseTradingDTO);
    }

    /**
     * Method which reads an exercise using the service ExerciseServiceImplements
     * @param exerciseTradingDTO The exercise to be read
     * @return The method "readExerciseTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IExerciseTradingEndPoints.URL_EXERCISE_READ)
    public ResponseEntity<ObjectResponse> readExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO) {
        return this.service.readExerciseTrading(exerciseTradingDTO);
    }

    /**
     * Method which reads all the exercises using the service ExerciseTradingServiceImplements
     * @return The method "readExercisesTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IExerciseTradingEndPoints.URL_EXERCISES_READ)
    public ResponseEntity<ObjectResponse> readExercisesTrading() {
        return this.service.readExercisesTrading();
    }

    /**
     * Method which updates an exercise using the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The exercise to be updated
     * @return The method "updateExerciseTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PutMapping(IExerciseTradingEndPoints.URL_EXERCISE_UPDATE)
    public ResponseEntity<ObjectResponse> updateExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO) {
        return this.service.updateExerciseTrading(exerciseTradingDTO);
    }

    /**
     * Method which deletes an exercise using the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The exercise to be deleted
     * @return The method "deleteExerciseTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IExerciseTradingEndPoints.URL_EXERCISE_DELETE)
    public ResponseEntity<ObjectResponse> deleteExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO) {
        return this.service.deleteExerciseTrading(exerciseTradingDTO);
    }
}

