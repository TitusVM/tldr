
package ch.hearc.tldr.controllers.implementations;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import ch.hearc.tldr.controllers.TLDRController;
import ch.hearc.tldr.models.implementation.TLDR;

@Controller
public class TLDRController_V1 implements TLDRController
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String saveTLDR(@ModelAttribute TLDR tldr, BindingResult errors, Model model)
		{
		// save a new TLDR
		return "redirect:/home";
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
