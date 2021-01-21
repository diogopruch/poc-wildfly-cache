/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.pucminas.arq.tcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.pucminas.arq.tcc.ibge.Municipio;
import redis.clients.jedis.Jedis;

public class Controller {

	private Jedis jedis = new Jedis("localhost", 6379);
	
	public List<Municipio> getMunicipios() throws Exception {
		//31 = Minas Gerais
		return getMunicipiosJson(31);
    }
	
	private List<Municipio> getMunicipiosJson(Integer cdEstadoIbge) throws IOException {
		String municipiosjson = jedis.get(cdEstadoIbge.toString());
		if (municipiosjson == null) {
			System.out.println("Buscando dados no serviço do IBGE");
			municipiosjson = readUrl("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + cdEstadoIbge + "/municipios");
			jedis.setex(cdEstadoIbge.toString(), 30, municipiosjson);
			
		}
		
		Gson gson = new Gson();
		Municipio[] municipios = gson.fromJson(municipiosjson, Municipio[].class); 
		
		return Arrays.asList(municipios);
	}
	
	
	private static String readUrl(String urlString) throws IOException  {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}


}
