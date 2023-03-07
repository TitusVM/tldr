
package ch.hearc.jee.tldr.rest_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.jee.tldr.entity.TLDR;

@RestController
@RequestMapping("api/tldrs/")
public class RestTLDRController
	{

	@GetMapping("/{id}", produces = "application/json")
    public TLDR getTLDR(@PathVariable int id)
		{
        return null;
		}
	}
