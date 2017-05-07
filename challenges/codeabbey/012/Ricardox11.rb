
respuesta = ''
puts 'Por favor ingresar N: ' # captura n
n = gets.chomp.to_i

for x in (1..n)
  puts "Por favor ingresar dato #{x}"
  time = gets.chomp # captura datos
  fecha = time.split(' ') # convierte a arreglo

  dia1 = fecha[0].to_i # separa datos
  hora1 = fecha[1].to_i
  min1 = fecha[2].to_i
  seg1 = fecha[3].to_i
  dia2 = fecha[4].to_i
  hora2 = fecha[5].to_i
  min2 = fecha[6].to_i
  seg2 = fecha[7].to_i

  fecha_seg1 = (dia1 * 86400) + (hora1 * 3600) + (min1 * 60) + seg1
  fecha_seg2 = (dia2 * 86400) + (hora2 * 3600) + (min2 * 60) + seg2

  fecha_dif_seg = (fecha_seg2 - fecha_seg1) # calcula diferencia

  dian = (fecha_dif_seg / 86400) # calcula dia
  horan = ((fecha_dif_seg % 86400) / 3600) # calcula hora
  minn  = (((fecha_dif_seg % 86400) % 3600) / 60) # calcula minutos
  segn = (((fecha_dif_seg % 86400) % 3600) % 60) # calcula segundos

  respuesta += "(#{dian} #{horan} #{minn} #{segn}) "
end

puts respuesta
