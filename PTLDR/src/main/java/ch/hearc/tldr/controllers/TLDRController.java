
package ch.hearc.tldr.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import ch.hearc.tldr.models.implementation.TLDR;

public interface TLDRController
	{

	public String saveTLDR(@ModelAttribute TLDR tldr, BindingResult errors, Model model);

	}
