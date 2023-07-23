package com.example.insuranceapplication.service.database.impl;

import com.example.insuranceapplication.entity.car.CarEngineCapacity;
import com.example.insuranceapplication.repository.carRepository.CarEngineCapacityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CarEngineCapacityDatabaseServiceImplTest {
@Mock
private CarEngineCapacityRepository carEngineCapacityRepository;
private CarEngineCapacityDatabaseServiceImpl underTest;

@InjectMocks
CarEngineCapacityDatabaseServiceImpl carEngineCapacityDatabaseService;

        @BeforeEach
        void setup() {
            underTest= new CarEngineCapacityDatabaseServiceImpl(carEngineCapacityRepository); }

    @Test
    void getEngineCapacity() {
        underTest.getEngineCapacity(3.4);
        verify(carEngineCapacityRepository).getEngineCapacityByEngineCapacityEquals(3.4);
    }

    @Test
    void getEngineCapacity_nullReturned() {
        underTest.getEngineCapacity(null);
        verify(carEngineCapacityRepository).getEngineCapacityByEngineCapacityEquals(isNull());
    }


    @Test
    void getCarEngineCapacityById() {
            underTest.getCarEngineCapacityById(1);
            verify(carEngineCapacityRepository).findById(1);
    }
    @Test
    void getCarEngineCapacityById_nullReturned() {
        underTest.getCarEngineCapacityById(null);
        verify(carEngineCapacityRepository).findById(isNull());
    }


    @Test
    void getAllCarEngineCapacity_success() {
        underTest.getAllCarEngineCapacity();
        verify(carEngineCapacityRepository).findAll();
        }

    @Test
    void getAllCarEngineCapacity_emptyListReturn() {
        underTest.getAllCarEngineCapacity().isEmpty();
        assertTrue (carEngineCapacityRepository.findAll().isEmpty());
    }

    @Test
    void getCoefficientCarEngineCapacity_success() {
            underTest.getCoefficientCarEngineCapacity(1.6);
            verify(carEngineCapacityRepository).getCoefficientCarEngineCapacity(1.6);
    }

    @Test
    void getCoefficientCarEngineCapacity_nullReturned() {
        underTest.getCoefficientCarEngineCapacity(null);
        verify(carEngineCapacityRepository).getCoefficientCarEngineCapacity(isNull());
    }


    @Test
    void delete() {
            underTest.delete(1);
            verify(carEngineCapacityRepository).deleteCarEngineCapacityById(1);
    }

    @Test
    void delete_nullReturned() {
        underTest.delete(null);
        verify(carEngineCapacityRepository).deleteCarEngineCapacityById(isNull());
    }


    @Test
    void create() {
        CarEngineCapacity carEngineCapacity = new CarEngineCapacity();
        underTest.create(carEngineCapacity);
        ArgumentCaptor<CarEngineCapacity> carEngineCapacityArgumentCaptor = ArgumentCaptor.forClass(CarEngineCapacity.class);
        verify(carEngineCapacityRepository).save(carEngineCapacityArgumentCaptor.capture());
        CarEngineCapacity capturedCarEngineCapacity = carEngineCapacityArgumentCaptor.getValue();
        assertEquals(capturedCarEngineCapacity, carEngineCapacity);
    }


    @Test
    void create_null() {
        CarEngineCapacity carEngineCapacity = new CarEngineCapacity();
        boolean b = underTest.create(carEngineCapacity) == null;

        ArgumentCaptor<CarEngineCapacity> carEngineCapacityArgumentCaptor = ArgumentCaptor.forClass(CarEngineCapacity.class);
        verify(carEngineCapacityRepository).save(carEngineCapacityArgumentCaptor.capture());
        CarEngineCapacity capturedCarEngineCapacity = carEngineCapacityArgumentCaptor.getValue();
        assertEquals(capturedCarEngineCapacity, carEngineCapacity);
    }


//    @Test
//    void findDeletedAgreements_nullListReturned() {
//        // given
//        when(agreementRepository.findAllDeleted()).thenReturn(null);
//
//        // when
//        List<AgreementDTO> actual = agreementDatabaseService.findDeletedAgreements();
//
//        // then
//        assertTrue(actual.isEmpty());
//    }
    //  @Test
    //    void update_success() {
    //        // given
    //        AgreementDTO updatedAgreementDTO = agreementDTO1;
    //        Agreement updatedAgreement = agreement1;
    //        Agreement agreementToUpdate = agreement2;
    //        when(agreementDTOMapper.mapDtoToEntity(updatedAgreementDTO)).thenReturn(updatedAgreement);
    //        when(agreementRepository.findById(uuid)).thenReturn(Optional.ofNullable(agreementToUpdate));
    //        when(agreementUpdateService.update(agreementToUpdate, updatedAgreement)).thenReturn(agreement1);
    //        // when
    //        agreementDatabaseService.update(uuid, updatedAgreementDTO);
    //        // then
    //        verify(agreementDTOMapper).mapDtoToEntity(updatedAgreementDTO);
    //        verify(agreementRepository).findById(uuid);
    //        verify(agreementUpdateService).update(agreementToUpdate, updatedAgreement);
    //        verify(agreementRepository).save(agreement1);
    //    }


//    @Test
//    void updateWithCheck() {
//
//        CarEngineCapacityUpdateDto carEngineCapacityUpdateDto = new CarEngineCapacityUpdateDto(1.1, 3.4);
//        Optional<CarEngineCapacity> carEngineCapacity = Optional.of(new CarEngineCapacity());
//    //    carEngineCapacity = carEngineCapacityRepository.findById(1);
//        underTest.updateWithCheck(1, carEngineCapacityUpdateDto);
//
//        ArgumentCaptor<CarEngineCapacity> carEngineCapacityArgumentCaptor = ArgumentCaptor.forClass(CarEngineCapacity.class);
//
//
//        verify(carEngineCapacityRepository).save(carEngineCapacityArgumentCaptor.capture());
//        CarEngineCapacity capturedCarEngineCapacity = carEngineCapacityArgumentCaptor.getValue();
//
//
//        assertEquals(capturedCarEngineCapacity, carEngineCapacity);
//    }

//       if (carEngineCapacityOptional.isPresent() && carEngineCapacityUpdateDto != null) {
//        CarEngineCapacity carEngineCapacity = carEngineCapacityOptional.get();
//        if (carEngineCapacityUpdateDto.getEngineCapacity() != null) {
//            carEngineCapacity.setEngineCapacity(carEngineCapacityUpdateDto.getEngineCapacity());
//        }
//        if (carEngineCapacityUpdateDto.getCoefficient() != null) {
//            carEngineCapacity.setCoefficient(carEngineCapacityUpdateDto.getCoefficient());
//        }
//        carEngineCapacityRepository.save(carEngineCapacity);
//        return Optional.of(carEngineCapacity);
//    }
//        return Optional.empty();


//    }





}