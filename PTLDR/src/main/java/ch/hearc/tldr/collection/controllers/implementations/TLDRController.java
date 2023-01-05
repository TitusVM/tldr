
package ch.hearc.tldr.collection.controllers.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.tldr.collection.models.implementation.TLDR;
import ch.hearc.tldr.collection.service.CollectionService;

@Controller
public class TLDRController
	{
	/*------------------------------------------------------------------*\
	|*							 Annotations							*|
	\*------------------------------------------------------------------*/

	@Autowired
	CollectionService collectionService;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@GetMapping(value = { "/", "/accueil" })
	public String showAccueilPage(Model model)
		{
		model.addAttribute("tldrs", collectionService.getAllTLDRsFromCollection());
		model.addAttribute("isPublic", Boolean.TRUE);
		model.addAttribute("showList", Boolean.TRUE);

		// DEBUG
		model.addAttribute("accueil", Boolean.TRUE);

		return "accueil";
		}

	@GetMapping(value = { "/new-tldr" })
	public String showNewTLDRForm(Model model)
		{
		model.addAttribute("accueil", Boolean.FALSE);
		model.addAttribute("isNew", Boolean.TRUE);
		model.addAttribute("showList", Boolean.FALSE);
		model.addAttribute("showNew", Boolean.TRUE);
		model.addAttribute("tldr", new TLDR());

		return "accueil";
		}

	@PostMapping(value = { "/save-tldr" })
	public String saveTLDR(@ModelAttribute TLDR tldr, BindingResult errors, Model model, @RequestParam String type)
		{
		if (type.equals("new"))
			{
			collectionService.addTLDRToCollection(tldr);
			}
		else
			{
			collectionService.deleteTLDR(tldr.getId());
			collectionService.addTLDRToCollection(tldr);
			}

		return "redirect:/"; // redirect nécessaire
		}

	@PostMapping(value = "/edit-beer")
	public String showNEditBeerForm(Model model, @RequestParam Long id)
		{
		TLDR tldrToEdit = collectionService.getTLDRById(id);

		model.addAttribute("tldr", tldrToEdit);
		model.addAttribute("showList", Boolean.FALSE);
		model.addAttribute("showNew", Boolean.TRUE);

		model.addAttribute("isEdit", Boolean.TRUE);
		model.addAttribute("isNew", Boolean.FALSE);

		return "/accueil";
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
