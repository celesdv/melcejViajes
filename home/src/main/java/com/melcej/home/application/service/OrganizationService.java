package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IOrganizationRepository;
import com.melcej.home.application.service.usecase.get.IGetOrganizationUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateOrganizationUseCase;
import com.melcej.home.domain.Organization;
import com.melcej.home.domain.SocialMedia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrganizationService implements IGetOrganizationUseCase, IUpdateOrganizationUseCase {

  private final IOrganizationRepository organizationRepository;

  @Override
  public Organization find() {
    try {
      Organization organization = organizationRepository.find();
      return organization;
    } catch (RuntimeException e) {
      throw new RecordNotFoundException("Organization not found.");
    }
  }

  @Override
  public Organization update(Organization updateOrganization) {
    return organizationRepository.update(updateValues(updateOrganization));
  }

  private Organization updateValues(Organization updateOrganization) {
    Organization savedOrganization = find();
    updateSocialMedia(savedOrganization, updateOrganization.getSocialMedia());
    updateTexts(savedOrganization, updateOrganization);
    updateBasicInformation(savedOrganization, updateOrganization);
    return savedOrganization;
  }

  private void updateBasicInformation(Organization savedOrganization,
      Organization updateOrganization) {
    String name = updateOrganization.getName();
    if (name != null) {
      savedOrganization.setName(name);
    }

    String image = updateOrganization.getImage();
    if (image != null) {
      savedOrganization.setImage(image);
    }

    String email = updateOrganization.getEmail();
    if (email != null) {
      savedOrganization.setEmail(email);
    }

    String phone = updateOrganization.getPhone();
    if (phone != null) {
      savedOrganization.setPhone(phone);
    }

    String address = updateOrganization.getAddress();
    if (address != null) {
      savedOrganization.setAddress(address);
    }
  }

  private void updateTexts(Organization savedOrganization, Organization updateOrganization) {
    String aboutUsText = updateOrganization.getAboutUsText();
    if (aboutUsText != null) {
      savedOrganization.setAboutUsText(aboutUsText);
    }
  }

  private void updateSocialMedia(Organization savedOrganization, SocialMedia updateSocialMedia) {
    if (updateSocialMedia != null) {
      String facebookUrl = updateSocialMedia.getFacebookUrl();
      if (facebookUrl != null) {
        savedOrganization.getSocialMedia().setFacebookUrl(facebookUrl);
      }

      String instagramUrl = updateSocialMedia.getInstagramUrl();
      if (instagramUrl != null) {
        savedOrganization.getSocialMedia().setInstagramUrl(instagramUrl);
      }
    }
  }
}
