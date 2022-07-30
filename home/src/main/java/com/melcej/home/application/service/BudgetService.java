package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IAssistanceRepository;
import com.melcej.home.application.repository.IBudgetRepository;
import com.melcej.home.application.repository.ICannedRepository;
import com.melcej.home.application.repository.IExcursionRepository;
import com.melcej.home.application.repository.IFlightRepository;
import com.melcej.home.application.repository.IHotelRepository;
import com.melcej.home.application.repository.ITransferRepository;
import com.melcej.home.application.service.usecase.add.ICreateBudgetUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteBudgetUseCase;
import com.melcej.home.application.service.usecase.get.IGetBudgetUseCase;
import com.melcej.home.application.service.usecase.list.IListBudgetUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateBudgetUseCase;
import com.melcej.home.domain.Assistance;
import com.melcej.home.domain.Budget;
import com.melcej.home.domain.Canned;
import com.melcej.home.domain.Excursion;
import com.melcej.home.domain.Flight;
import com.melcej.home.domain.Hotel;
import com.melcej.home.domain.Order;
import com.melcej.home.domain.Transfer;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class BudgetService implements ICreateBudgetUseCase, IDeleteBudgetUseCase, IGetBudgetUseCase,
    IListBudgetUseCase, IUpdateBudgetUseCase {

  private final IBudgetRepository budgetRepository;
  private final IAssistanceRepository assistanceRepository;
  private final ICannedRepository cannedRepository;
  private final IExcursionRepository excursionRepository;
  private final IFlightRepository flightRepository;
  private final IHotelRepository hotelRepository;
  private final ITransferRepository transferRepository;

  @Override
  public Budget add(Budget budget) {
    budget.setSoftDelete(false);
    calculateTotalPrice(budget);
    return budgetRepository.add(budget);
  }

  @Override
  public void delete(Long id) {
    if (!budgetRepository.existsById(id) || transferRepository.isDeleted(id)){
      throw new RecordNotFoundException("Budget not found");
    }
    budgetRepository.delete(id);
  }

  @Override
  public Budget find(@PathVariable Long id) {
    Budget budget = budgetRepository.findBy(id);
    if (budget == null || Boolean.TRUE.equals(budget.getSoftDelete())){
      throw new RecordNotFoundException("Budget not found");
    }
    return budget;
  }

  @Override
  public Page<Budget> findAll(PageRequest pageRequest) {
    return budgetRepository.findAll(pageRequest);
  }

  @Override
  public Budget update(Budget budgetUpdate) {
    Budget budgetSaved = find(budgetUpdate.getId());
    budgetSaved.setSoftDelete(false);
    updateValues(budgetSaved, budgetUpdate);
    return budgetRepository.update(budgetSaved);
  }

  private void updateValues(Budget budgetSaved, Budget budgetUpdate) {
    Order order = budgetUpdate.getOrder();
    if (order != null){
      budgetSaved.setOrder(order);
    }

    String details = budgetUpdate.getDetail();
    if (details != null) {
      budgetSaved.setDetail(details);
    }

    Double totalPrice = budgetUpdate.getTotalPrice();
    if (totalPrice != null){
      budgetSaved.setTotalPrice(totalPrice);
    }
  }

  private void calculateTotalPrice(Budget budget) {
    Double assistancePrice = assistancePrice(budget);
    Double cannedPrice = cannedPrice(budget);
    Double excursionPrice = excursionPrice(budget);
    Double flightPrice = flightPrice(budget);
    Double hotelPrice = hotelPrice(budget);
    Double transferPrice = transferPrice(budget);

    Double totalPrice = assistancePrice + cannedPrice + excursionPrice + flightPrice + hotelPrice + transferPrice;
    budget.setTotalPrice(totalPrice);
  }

  private Double transferPrice(Budget budget) {
    Double transferPrice = 0.0;
    List<Transfer> transferList = transferRepository.findAllByBudget(budget.getId());
    for (Transfer transfer: transferList){
      transferPrice = transferPrice + transfer.getValue() + transfer.getTax();
    }
    return transferPrice;
  }

  private Double hotelPrice(Budget budget) {
    Double hotelPrice = 0.0;
    List<Hotel> hotelList = hotelRepository.findAllByBudget(budget.getId());
    for (Hotel hotel: hotelList) {
      hotelPrice = hotelPrice + hotel.getValue() + hotel.getTax();
    }
    return hotelPrice;
  }

  private Double flightPrice(Budget budget) {
    Double flightPrice = 0.0;
    List<Flight> flightList = flightRepository.findAllByBudget(budget.getId());
    for (Flight flight: flightList){
      flightPrice = flightPrice + flight.getValue() + flight.getTax();
    }
    return flightPrice;
  }

  private Double excursionPrice(Budget budget) {
    Double excursionPrice = 0.0;
    List<Excursion> excursionList = excursionRepository.findAllByBudget(budget.getId());
    for (Excursion excursion : excursionList) {
      excursionPrice = excursionPrice + excursion.getValue() + excursion.getTax();
    }
    return excursionPrice;
  }

  private Double cannedPrice(Budget budget) {
    Double cannedPrice = 0.0;
    List<Canned> cannedList = cannedRepository.findAllByBudget(budget.getId());
    for (Canned canned: cannedList) {
      cannedPrice = cannedPrice + canned.getValue() + canned.getTax();
    }
    return cannedPrice;
  }

  private Double assistancePrice(Budget budget) {
    Double assistancePrice = 0.0;
    List<Assistance> assistanceList = assistanceRepository.findAllByBudget(budget.getId());
    for (Assistance assistance: assistanceList) {
      assistancePrice = assistancePrice + assistance.getValue() + assistance.getTax();
    }
    return assistancePrice;
  }

}
